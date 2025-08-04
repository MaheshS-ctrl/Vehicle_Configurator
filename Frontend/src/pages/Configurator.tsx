import { useEffect, useState } from 'react';
import axios from 'axios';

const Configurator = () => {
  const [segments, setSegments] = useState([]);
  const [manufacturers, setManufacturers] = useState([]);
  const [models, setModels] = useState([]);

  const [selectedSegment, setSelectedSegment] = useState('');
  const [selectedManufacturer, setSelectedManufacturer] = useState('');

  // Fetch all segments dynamically
  useEffect(() => {
    axios.get('http://localhost:8081/segments')
      .then(res => setSegments(res.data))
      .catch(err => console.error('Failed to fetch segments', err));
  }, []);

  const handleSegmentSelect = (segmentId: string) => {
    setSelectedSegment(segmentId);
    setManufacturers([]);
    setModels([]);

    axios.get(`http://localhost:8080/api/segment/${segmentId}/manufacturers`)
      .then(res => setManufacturers(res.data))
      .catch(err => console.error('Failed to fetch manufacturers', err));
  };

  const handleManufacturerSelect = (manufacturerId: string) => {
    setSelectedManufacturer(manufacturerId);
    setModels([]);

    axios.get(`http://localhost:8080/api/manufacturer/${manufacturerId}/models`)
      .then(res => setModels(res.data))
      .catch(err => console.error('Failed to fetch models', err));
  };

  return (
    <div className="min-h-screen bg-gray-900 text-white p-8">
      <h1 className="text-4xl font-bold mb-8 text-center">Vehicle Configuration</h1>

      {/* Segment Dropdown */}
      <div className="mb-6">
        <label className="block mb-2 text-lg">Select Segment:</label>
        <select
          value={selectedSegment}
          onChange={(e) => handleSegmentSelect(e.target.value)}
          className="w-full p-3 bg-gray-800 rounded border border-white/20"
        >
          <option value="">-- Select Segment --</option>
          {segments.map((seg: any) => (
            <option key={seg.id} value={seg.id}>
              {seg.name}
            </option>
          ))}
        </select>
      </div>

      {/* Manufacturer Dropdown */}
      {manufacturers.length > 0 && (
        <div className="mb-6">
          <label className="block mb-2 text-lg">Select Manufacturer:</label>
          <select
            value={selectedManufacturer}
            onChange={(e) => handleManufacturerSelect(e.target.value)}
            className="w-full p-3 bg-gray-800 rounded border border-white/20"
          >
            <option value="">-- Select Manufacturer --</option>
            {manufacturers.map((manu: any) => (
              <option key={manu.id} value={manu.id}>
                {manu.name}
              </option>
            ))}
          </select>
        </div>
      )}

      {/* Model Dropdown */}
      {models.length > 0 && (
        <div className="mb-6">
          <label className="block mb-2 text-lg">Select Model:</label>
          <select className="w-full p-3 bg-gray-800 rounded border border-white/20">
            <option value="">-- Select Model --</option>
            {models.map((mod: any) => (
              <option key={mod.id} value={mod.id}>
                {mod.name}
              </option>
            ))}
          </select>
        </div>
      )}
    </div>
  );
};

export default Configurator;
